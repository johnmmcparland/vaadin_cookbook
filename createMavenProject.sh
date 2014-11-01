#!/bin/sh 
#######################################
## Create a Vaadin project
## See https://vaadin.com/book/-/page/getting-started.maven.html
##
## Apache 2.0 Licensed.  See LICENSE file.
## Args
## 1. artifact Id (name of the project)
##
## John McParland
## Su 11 Oct 2014
#######################################

## Get program arguments (one, the artifact ID)
if [[ 1 -ne ${#} ]];then
    echo "[ERROR] One argument required, the artifact ID"
	exit 0
fi

GROUPID=`grep "<groupId>" pom.xml | sed -n 1p | cut -f2 -d">" | cut -f1 -d"<"`
ARTIFACTID=${1}
VERSION=`grep "<version>" pom.xml | sed -n 1p | cut -f2 -d">" | cut -f1 -d"<"`
VAADINVERSION=`grep vaadin.version pom.xml | sed -n 1p | cut -f2 -d">" | cut -f1 -d"<"`

echo "[INFO] Creating project with"
echo "    Artifact ID:    ${ARTIFACTID}"
echo "    Vaadin Version: ${VAADINVERSION}"

# Generate!
mvn archetype:generate \
    -DarchetypeGroupId=com.vaadin \
    -DarchetypeArtifactId=vaadin-archetype-application \
    -DarchetypeVersion=${VAADINVERSION} \
    -DinteractiveMode=false \
    -DgroupId=${GROUPID} \
    -DartifactId=${ARTIFACTID} \
    -Dversion=${VERSION} \
    -Dpackaging=war

# Copy .gitignore
cp .gitignore ${ARTIFACTID}/

# Modify...
# <source>${java.version}</source> (from 1.6)
# <target>${java.version}</target> (from 1.6)
#sed -i 's/1.6/${java.version}/g' ${ARTIFACTID}/pom.xml

# Update the pom to contain the right java version, plugin versions
# and more
cp TEMPLATE_POM.xml ${ARTIFACTID}/pom.xml
sed -i 's/ARTIFACTID/${ARTIFACTID}/g' ${ARTIFACTID}/pom.xml

echo "[INFO] Complete.  If the above succeeded try"
echo "       cd ${ARTIFACTID}"
echo "       mvn clean package"
echo "       mvn jetty:run"
echo "       Visit http://localhost:8080"

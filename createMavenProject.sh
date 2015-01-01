#!/bin/sh 
#######################################
## Create a Vaadin project
## See https://vaadin.com/book/-/page/getting-started.maven.html
##
## Apache 2.0 Licensed.  See LICENSE file.
## Args
## 1. artifact Id (name of the project)
## 2. Chapter directory name (e.g. Chapter03)
##
## John McParland
## Su 11 Oct 2014
#######################################

## Get program arguments (one, the artifact ID)
if [[ 2 -ne ${#} ]];then
    echo "[ERROR] Two arguments required"
	echo "The artifact ID (e.g. ch03_insertingBtn)"
	echo "The Chapter directory name (e.g. Chapter03)"
	echo "E.g. ./createMavenProject.sh ch03_insertingBtn Chapter03"
	exit 0
fi

GROUPID=`grep "<groupId>" pom.xml | sed -n 1p | cut -f2 -d">" | cut -f1 -d"<"`
ARTIFACTID=${1}
VERSION=`grep "<version>" pom.xml | sed -n 1p | cut -f2 -d">" | cut -f1 -d"<"`
VAADINVERSION=`grep vaadin.version pom.xml | sed -n 1p | cut -f2 -d">" | cut -f1 -d"<"`
CHAPTERDIR=${2}

if [[ ! -d ${CHAPTERDIR} ]];then
    echo "[ERROR] ${CHAPTERDIR} does not exist, please create manually".
	exit 0
else 
    cd ${CHAPTERDIR}
fi

echo "[INFO] Creating project with"
echo "    Artifact ID:    ${ARTIFACTID}"
echo "    Vaadin Version: ${VAADINVERSION}"
echo "    Chapter:        ${CHAPTERDIR}"

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
cp ../.gitignore ${ARTIFACTID}/

# Modify...
# <source>${java.version}</source> (from 1.6)
# <target>${java.version}</target> (from 1.6)
#sed -i 's/1.6/${java.version}/g' ${ARTIFACTID}/pom.xml

# Update the pom to contain the right java version, plugin versions
# and more
cp ../TEMPLATE_POM.xml ${ARTIFACTID}/pom.xml
sed -i "s/ARTIFACTID/${ARTIFACTID}/g" ${ARTIFACTID}/pom.xml
sed -i "s/CHAPTERDIR/${CHAPTERDIR}/g" ${ARTIFACTID}/pom.xml

echo "[INFO] Complete.  If the above succeeded try"
echo "       cd ${CHAPTERDIR}/${ARTIFACTID}"
echo "       mvn clean package"
echo "       mvn jetty:run"
echo "       Visit http://localhost:8080"

cd -

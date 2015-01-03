#!/bin/sh
BUILDLOG=build.log

if [[ -f ${BUILDLOG} ]];then
    rm ${BUILDLOG}
fi

mvn clean package install 2>&1 | tee -a ${BUILDLOG}

grep WARN ${BUILDLOG} | grep -v "Failed to retrieve" | grep -v "Referencing deprecated" | grep -v "Warnings in '" | grep -v "Ignoring missing resource" | grep -v "No file to scan."

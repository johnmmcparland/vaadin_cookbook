vaadin_cookbook
===============

Code based upon the examples in the Vaadin 7 Cookbook [1].  

The code is either my own or copied from the examples provided via the books code download [2].

All files are released under The Apache License, version 2 [3]. 
 
The full license is included in file named LICENSE.

---
Organisation
------------
The project has a parent pom.xml which references children, one for each chapter.  Chapters are named ChapterXX where XX corresponds the the Chapter number.

Each child (chapter) has all the examples in it for that chapter.  Naming is free form but once followed the convention of chXX_loremIpsum.

---
Creating a subproject
---------------------
Do 
```shell
./createMavenProject.sh <artifactId> <ChapterNumber>
```

E.g.

```shell
./createMavenProject.sh ch03_insertBtn Chapter03
```

From the vaadin_cookbook diretory.

Sorry to create a new chapter, you'll need to do it manually.

---

[1] Holaň, J; Kvasnovský O (2013). Vaadin 7 Cookbook. Birmingham: Packt Publishing. All.

[2] Holaň, J; Kvasnovský O. (2013). Vaadin 7 Cookbook Download. Available: http://www.packtpub.com/support/11498. Last accessed 2nd June 2014.

[3] The Apache Softaware Foundation (2004). Apache License, Version 2.0. Available: http://www.apache.org/licenses/LICENSE-2.0. Last accessed 5th June 2014.

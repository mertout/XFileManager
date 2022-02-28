## XFile Manager

```java
getManager().writeFile("xyz"#path, "123"#to, "test"#file, "data/x")#file;
System.out.println(getManager().getObjectFile("xyz"#path, "test"#file));
getManager().nameToFileCFG("settings").getString("settings.xyz");
getManager().nameToFile("settings").getString("settings.xyz");
getManager().nameToFile("arenas").mkdirs();
```

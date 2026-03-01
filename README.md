# minikit

Minikit is a small, experimental server plugin for Minecraft 1.21.11. Specifically for PaperMC servers.

## What's in the box

The plugin itself does not contain a large suite of high quality, production ready tools and systems. It's just a basic collection of commands that server operators (and the console) can access and make use of. Below is the list of all commands and how to use them.

```
/flyspd  <target> <speed>
/sstats
/creeper <target> <charged>
/fish    <target> <n>
/tban    <target> <duration in minutes>
/pban    <target>
/pardon  <target>
/smite   <target>
/jail    <target> <duration in seconds>
/gm      <on/off> (toggle)
/minikithelp
```

And for 1.0, that's it. I'll come back to this project periodically to update commands, improve code, and add new commands. 👀

## Installing the plugin

You'll want both the Java JDK and JRE, I recommend the openJDK.
  * _At least version 21 is required!_
  * _Maven is also required!_

Once you've got the repo cloned with `git clone` or your choice of repo management, it's as easy as running `mvn` to build the plugin.

---

If you don't want to build from source, you just need the JDK, and the [PaperMC JAR file](https://papermc.io/). The latest build of the plugin is in the [Releases](https://github.com/sapphicnerddev/minikit/releases) page.

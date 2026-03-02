# minikit

[![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?logo=openjdk&logoColor=%23000000)](#)
![Static Badge](https://img.shields.io/badge/Maven-black?logo=apachemaven&logoColor=%23C71A36)

<!-- Last edit before I start committing code I promise -->
Minikit is a small, experimental server plugin for Minecraft 1.21.11. Specifically for PaperMC servers.

## What's in the box

The plugin itself does not contain a large suite of high quality, production ready tools and systems. It's just a basic collection of commands that server operators (and the console) can access and make use of. Below is the list of all commands and how to use them.

```
/flyspd  <target> <speed>          Sets a player's fly speed (float)
/sstats                            Displays server CPU and RAM info
/creeper <target> <charged>        Spawns a creeper on a target player
/fish    <target> <n>              Spawns n fish on a target player
/tban    <target> <duration>       Temporarily bans a player (duration in minutes)
/pban    <target>                  Permanently bans a player
/mpardon <target>                  Pardons a banned player (differentiated from vanilla bans)
/smite   <target>                  ⚡️⚡️
/jail    <target> <duration>       Traps a player in bedrock (duration in seconds)
/gm      <on/off>                  Toggles godmode for a player
/minikithelp                       Displays all available commands
```

Target selectors (`@a`, `@r`, `@p`) are supported. Use them wisely!
<sub> You can also just... have fun, I can't really stop you!</sub>

And for 1.0, that's it. I'll come back to this project periodically to update commands, improve code, and add new commands. 👀

## Permissions

All commands are restricted to server operators only. No additional permission nodes are required.

## Installing the plugin

You'll want both the Java JDK and JRE, I recommend the openJDK.
  * _At least version 21 is required!_
  * _Maven is also required!_

Once you've got the repo cloned with `git clone` or your choice of repo management, it's as easy as running `mvn` to build the plugin.

> [!NOTE]
> If you're building from source, we assume that you already have an IDE like IntelliJ or VSCode setup for Java development.

---

If you don't want to build from source, you just need the JRE, and the [PaperMC JAR file](https://papermc.io/). The latest build of the plugin is in the [Releases](https://github.com/sapphicnerddev/minikit/releases) page.

## Setting up a Paper server

If you're starting from scratch:

1. Download the latest Paper JAR from [papermc.io](https://papermc.io/)
      - Should be at least version 1.21.11
2. Run it once with `java -jar paper-<version>.jar` — it will generate a `eula.txt`
      - Alt: you can execute `echo eula=true > eula.txt` in your terminal.
3. Open `eula.txt` and set `eula=true`
4. Run the JAR again — your server is up

For a more detailed setup guide, refer to the [official Paper documentation](https://docs.papermc.io/).

## Dropping in the plugin

1. Place the minikit JAR into your server's `plugins/` folder
2. Restart the server
3. Confirm it loaded by running `/plugins` in the console — minikit should appear in the list

---

## Contributing / Posting Issues

This is an open-source project that is licensed under [MIT](./LICENSE). You're welcome to fork this project and make edits as you need or want, or you can open Issues with this repo for feature requests or to suggest fixes! Any and all help is welcome! ~~I'm still learning Java so some things are likely not well implemented.~~

---

> Spawning large numbers of entities will lag or crash your server. You have been warned!







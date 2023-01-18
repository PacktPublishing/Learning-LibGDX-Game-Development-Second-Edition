


#Learning LibGDX Game Development- Second Edition

This is the code repository for [Learning LibGDX Game Development- Second Edition](https://www.packtpub.com/game-development/learning-libgdx-game-development-second-edition?utm_source=github&utm_medium=repository&utm_campaign=9781783554775), published by Packt. It contains all the supporting project files necessary to work through the book from start to finish.

##Instructions and Navigation
All of the code is organized into folders. Each folder starts with Chapter followed by Chapter Number. For Example, Chapter 2. The Chapter 1 not contains any code it's for setting up the system environment. 

Each Chapter contains lots of code. You will see code something similler to the following:
```
<config>
	<executableName>${app.executable}</executableName>
		<mainClass>${app.mainclass}</mainClass>
			<os>ios</os>
			<arch>thumbv7</arch>
			<target>ios</target>
			<iosInfoPList>Info.plist.xml</iosInfoPList>
		<resources>
			<resource>
				<directory>../android/assets</directory>
				<includes>
					<include>**</include>
				</includes>
				<skipPngCrush>true</skipPngCrush>
			</resource>
			<resource>
				<directory>data</directory>
			</resource>
		</resources>
	<forceLinkClasses>
		<pattern>com.badlogic.gdx.scenes.scene2d.ui.*</pattern>
	</forceLinkClasses>
	<libs>
		<lib>libs/ios/libgdx.a</lib>
		<lib>libs/ios/libObjectAL.a</lib>
	</libs>
	<frameworks>
		<framework>UIKit</framework>
		<framework>OpenGLES</framework>
		<framework>QuartzCore</framework>
		<framework>CoreGraphics</framework>
		<framework>OpenAL</framework>
		<framework>AudioToolbox</framework>
		<framework>AVFoundation</framework>
	</frameworks>
</config>
```
##Related Entity Framework Products:
* [Learning Libgdx Game Development](https://www.packtpub.com/game-development/learning-libgdx-game-development?utm_source=github&utm_medium=repository&utm_campaign=9781782166047)
* [Learning Libgdx Game Development](https://www.packtpub.com/game-development/learning-libgdx-game-development?utm_source=github&utm_medium=repository&utm_campaign=9781782166047)
* [Libgdx Cross-platform Game Development Cookbook](https://www.packtpub.com/game-development/libgdx-cross-platform-game-development-cookbook?utm_source=github&utm_medium=repository&utm_campaign=9781783287291)
* [LibGDX Game Development Essentials](https://www.packtpub.com/game-development/libgdx-game-development-essentials?utm_source=github&utm_medium=repository&utm_campaign=9781784399290)
### Download a free PDF

 <i>If you have already purchased a print or Kindle version of this book, you can get a DRM-free PDF version at no cost.<br>Simply click on the link to claim your free PDF.</i>
<p align="center"> <a href="https://packt.link/free-ebook/9781783554775">https://packt.link/free-ebook/9781783554775 </a> </p>
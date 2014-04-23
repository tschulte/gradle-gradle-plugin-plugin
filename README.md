### Build Status
[![Build Status](https://travis-ci.org/tschulte/gradle-gradle-plugin-plugin.svg?branch=master)](https://travis-ci.org/tschulte/gradle-gradle-plugin-plugin)
# Overview
This plugin creates gradle plugin descriptor files.

# Usage
To use the plugin, configure your `build.gradle` script and add the plugin:
```groovy
    buildscript {
        repositories {
            jcenter()
        }
        dependencies {
            classpath 'de.gliderpilot.gradle.plugins:gradle-gradle-plugin-plugin:VERSION'
        }
    }
    apply plugin: 'gradle-plugin'
```

# Tasks
The plugin adds `generate${sourceSet.name}GradlePluginDescriptors` tasks to your projects and alters
the sourceset to contain the output of the task. These tasks are automatically executed.

## Configuration

sourceSets.main is enabled by default, you might use this to enable generation for other sourceSets

### build.gradle
```groovy
    gradlePluginDescriptor {
        enableFor(sourceSets.test)
    }
```

# License
This plugin is available under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0).

(c) All rights reserved Tobias Schulte

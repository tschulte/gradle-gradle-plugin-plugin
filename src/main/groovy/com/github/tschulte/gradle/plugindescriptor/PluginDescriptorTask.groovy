package com.github.tschulte.gradle.plugindescriptor

import org.gradle.api.*
import org.gradle.api.file.ConfigurableFileTree
import org.gradle.api.tasks.*

class PluginDescriptorTask extends DefaultTask {
	
	
    private ConfigurableFileTree pluginFiles

    private File generatedResourcesDir

    void from(Object classesDir) {
        pluginFiles = project.fileTree(classesDir) {
			include '**/*Plugin.class'
			exclude '**/Abstract*'
		}
    }

    void into(Object into) {
        generatedResourcesDir = project.file(into)
    }

    @InputFiles
    @SkipWhenEmpty
    def getFrom() {
        pluginFiles
    }

    @OutputDirectory
    File getGeneratedResourcesDir() {
        generatedResourcesDir
    }

    @TaskAction
    void generatePluginDescriptors() {
        pluginDescriptors().each { name, clazz ->
			Properties properties = new Properties()
			properties.'implementation-class' = clazz
			new File(generatedResourcesDir, "${name}.properties").withOutputStream { os ->
				properties.store(os, null)
			}
        }
    }
	
	def pluginDescriptors() {
		PluginDescriptorUtil.pluginDescriptors(pluginFiles.dir, pluginFiles.files)
	}
	
}
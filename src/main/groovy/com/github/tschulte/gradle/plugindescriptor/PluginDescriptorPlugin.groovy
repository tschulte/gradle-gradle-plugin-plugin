package com.github.tschulte.gradle.plugindescriptor
/**
 * Created by tobias on 12/9/13.
 */
 
import org.gradle.api.*
import org.gradle.api.tasks.*
 
public class PluginDescriptorPlugin implements Plugin<Project> {

    Project project

	public void apply(Project project) {
        this.project = project
        project.extensions.create('pluginDescriptor', PluginDescriptorPluginExtension, this)
        project.with {
            apply plugin: 'java'

            dependencies {
                compile gradleApi()
                compile localGroovy()
            }

            enableFor(sourceSets.main)

        }
	}

    void enableFor(SourceSet sourceSet) {
        def name = sourceSet.name
        def generatedResources = "${project.buildDir}/generated-resources/$name"
        def nameFirstUpper = name.replaceFirst(name[0], name[0].toUpperCase())
        def taskName = "generate${nameFirstUpper}PluginDescriptors"
		if (!project.tasks.names.contains(taskName)) {
	        sourceSet.output.dir(generatedResources, builtBy: taskName)
	
	        project.task(taskName, type: PluginDescriptorTask) {
	            from sourceSet.output.classesDir
	            into "$generatedResources/META-INF/gradle-plugins"
	        }
		}

    }
}

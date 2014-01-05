package de.gliderpilot.gradle.plugins.gradleplugin
/**
 * Created by tobias on 12/9/13.
 */
 
import org.gradle.api.*
import org.gradle.api.tasks.*
 
public class GradlePluginDescriptorPlugin implements Plugin<Project> {

    Project project

	public void apply(Project project) {
        this.project = project
        project.extensions.create('gradlePluginDescriptor', GradlePluginDescriptorPluginExtension, this)
        project.plugins.apply 'java-base'
		if (project.sourceSets.names.contains('main')) {
			enableFor(project.sourceSets.main)
		}
	}

    void enableFor(SourceSet sourceSet) {
        def name = sourceSet.name
        def generatedResources = "${project.buildDir}/generated-gradle-plugin-descriptors/$name"
        def nameFirstUpper = name.capitalize()
        def taskName = "generate${nameFirstUpper}GradlePluginDescriptors"
		if (!project.tasks.names.contains(taskName)) {
	        sourceSet.output.dir(generatedResources, builtBy: taskName)
	
	        project.task(taskName, type: GradlePluginDescriptorTask) {
	            from sourceSet.output.classesDir
	            into "$generatedResources/META-INF/gradle-plugins"
	        }
		}

    }
}

package de.gliderpilot.gradle.plugins.gradleplugin
/**
 * Created by tobias on 12/9/13.
 */
 
import org.gradle.api.*
import org.gradle.api.tasks.*
 
public class GradlePluginPlugin implements Plugin<Project> {

    Project project

	public void apply(Project project) {
        this.project = project
        project.with {
            plugins.apply 'groovy'
			plugins.apply GradlePluginDescriptorPlugin

            dependencies {
                compile gradleApi()
                compile localGroovy()
            }
        }
	}

}

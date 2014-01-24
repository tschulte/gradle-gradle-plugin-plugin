package de.gliderpilot.gradle.plugins.gradleplugin

import static org.junit.Assert.*
import static org.junit.Assert.*

import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test


class TestGradlePluginDescriptorPlugin {

	@Test
	public void testApplyPluginDescriptorPlugin() {
		def project = ProjectBuilder.builder().build()
		project.with {
			apply plugin: 'java'
			apply plugin: 'gradle-plugin-descriptor'
		}

		assertNotNull project.tasks.generateGradlePluginDescriptors

	}
	@Test
	public void testApplyPluginDescriptorPluginEnableForMain() {
		def project = ProjectBuilder.builder().build()
		project.with {
			apply plugin: 'java'
			apply plugin: 'gradle-plugin-descriptor'
			gradlePluginDescriptor {
				enableFor(sourceSets.main)
			}
		}

		assertNotNull project.tasks.generateGradlePluginDescriptors
	}
	@Test
	public void testApplyPluginDescriptorPluginEnableForTest() {
		def project = ProjectBuilder.builder().build()
		project.with {
			apply plugin: 'java'
			apply plugin: 'gradle-plugin-descriptor'
			gradlePluginDescriptor {
				enableFor(sourceSets.test)
			}
		}

		assertNotNull project.tasks.generateTestGradlePluginDescriptors
	}

}

package com.github.tschulte.gradle.plugindescriptor

import static org.junit.Assert.*
import org.gradle.testfixtures.ProjectBuilder

import static org.junit.Assert.*

import org.junit.Test


class TestPluginDescriptorPlugin {

	@Test
	public void testApplyPluginDescriptorPlugin() {
		def project = ProjectBuilder.builder().build()
		project.with {
			apply plugin: 'plugin-descriptor'
		}

		assertNotNull project.tasks.generateMainPluginDescriptors

	}
	@Test
	public void testApplyPluginDescriptorPluginEnableForMain() {
		def project = ProjectBuilder.builder().build()
		project.with {
			apply plugin: 'plugin-descriptor'
			pluginDescriptor {
				enableFor(sourceSets.main)
			}
		}

		assertNotNull project.tasks.generateMainPluginDescriptors
	}
	@Test
	public void testApplyPluginDescriptorPluginEnableForTest() {
		def project = ProjectBuilder.builder().build()
		project.with {
			apply plugin: 'plugin-descriptor'
			pluginDescriptor {
				enableFor(sourceSets.test)
			}
		}

		assertNotNull project.tasks.generateTestPluginDescriptors
	}

}

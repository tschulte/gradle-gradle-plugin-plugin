package de.gliderpilot.gradle.plugins.gradleplugin

import javax.inject.Inject;

import org.gradle.api.tasks.SourceSet;

public class GradlePluginDescriptorPluginExtension {
	
	private GradlePluginDescriptorPlugin plugin

	@Inject
	public GradlePluginDescriptorPluginExtension(GradlePluginDescriptorPlugin plugin) {
		this.plugin = plugin
	}

	void enableFor(SourceSet sourceSet) {
		plugin.enableFor(sourceSet)
	}
}

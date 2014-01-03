package com.github.tschulte.gradle.plugindescriptor

import javax.inject.Inject;

import org.gradle.api.tasks.SourceSet;

public class PluginDescriptorPluginExtension {
	
	private PluginDescriptorPlugin plugin

	@Inject
	public PluginDescriptorPluginExtension(PluginDescriptorPlugin plugin) {
		this.plugin = plugin
	}

	void enableFor(SourceSet sourceSet) {
		plugin.enableFor(sourceSet)
	}
}

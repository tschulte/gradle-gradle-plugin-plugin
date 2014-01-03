package com.github.tschulte.gradle.plugindescriptor

import java.util.regex.Pattern

class PluginDescriptorUtil {

	private static final Pattern PACKAGE = ~/^.*\./
	private static final Pattern PLUGIN_SUFFIX = ~/Plugin$/
	private static final Pattern FIRST_UPPER = ~/^\p{Upper}/
	private static final Pattern UPPER = ~/\p{Upper}/

	private static final Pattern CLASSFILE_EXTENSION = ~/\.class$/
	private static final Pattern LEADING_DOT = ~/^\./

	static String toPluginName(String className) {
		(className - PACKAGE - PLUGIN_SUFFIX)
			.replaceFirst(FIRST_UPPER) { it.toLowerCase() }
			.replaceAll(UPPER) { "-${it.toLowerCase()}" }
	}
	
	static def pluginDescriptors(File baseDir, Iterable<File> pluginClassFiles) {
		def pluginDescriptorData = PluginDescriptorUtil.&pluginDescriptor.curry(baseDir)
		pluginClassFiles.collect(pluginDescriptorData).collectEntries()
	}

	static def pluginDescriptor(File baseDir, File pluginClassFile) {
		String className = (pluginClassFile.canonicalPath - baseDir.canonicalPath).replace(File.separator, '.') - LEADING_DOT - CLASSFILE_EXTENSION
		String pluginName = toPluginName(className)
		def descriptorData = [:]
		descriptorData[pluginName] = className
		descriptorData
	}

}

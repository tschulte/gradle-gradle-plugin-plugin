package com.github.tschulte.gradle.plugindescriptor

import static org.junit.Assert.*

import org.junit.Test

class TestPluginDescriptorUtil {
	
	@Test
	void testSimplePluginName() {
		assertEquals('foo', PluginDescriptorUtil.toPluginName('FooPlugin'))
	}

	@Test
	void testSimplePluginNameWithPackage() {
		assertEquals('foo', PluginDescriptorUtil.toPluginName('test.package.FooPlugin'))
	}

	@Test
	void testMultiPluginName() {
		assertEquals('foo-bar', PluginDescriptorUtil.toPluginName('FooBarPlugin'))
	}

	@Test
	void testMultiPluginNameWithPackage() {
		assertEquals('foo-bar', PluginDescriptorUtil.toPluginName('test.package.FooBarPlugin'))
	}

	@Test
	public void testPluginDescriptor() {
		def data = PluginDescriptorUtil.pluginDescriptor(new File('/foo/'), new File('/foo/package/FooBarPlugin.class'))
		assertEquals(1, data.size())
		assertEquals('package.FooBarPlugin', data.'foo-bar')
	}

	@Test
	public void testPluginDescriptors() {
		def data = PluginDescriptorUtil.pluginDescriptors(new File('/foo/'), [new File('/foo/package/FooBarPlugin.class'), new File('/foo/package/FooBarBazPlugin.class')])
		assertEquals(2, data.size())
		assertEquals('package.FooBarPlugin', data.'foo-bar')
		assertEquals('package.FooBarBazPlugin', data.'foo-bar-baz')
	}
}

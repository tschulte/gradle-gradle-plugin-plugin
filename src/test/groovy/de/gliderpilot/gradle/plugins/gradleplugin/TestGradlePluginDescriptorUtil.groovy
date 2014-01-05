package de.gliderpilot.gradle.plugins.gradleplugin

import static org.junit.Assert.*

import org.junit.Test

import de.gliderpilot.gradle.plugins.gradleplugin.GradlePluginDescriptorUtil;

class TestGradlePluginDescriptorUtil {
	
	@Test
	void testSimplePluginName() {
		assertEquals('foo', GradlePluginDescriptorUtil.toPluginName('FooPlugin'))
	}

	@Test
	void testSimplePluginNameWithPackage() {
		assertEquals('foo', GradlePluginDescriptorUtil.toPluginName('test.package.FooPlugin'))
	}

	@Test
	void testMultiPluginName() {
		assertEquals('foo-bar', GradlePluginDescriptorUtil.toPluginName('FooBarPlugin'))
	}

	@Test
	void testMultiPluginNameWithPackage() {
		assertEquals('foo-bar', GradlePluginDescriptorUtil.toPluginName('test.package.FooBarPlugin'))
	}

	@Test
	public void testPluginDescriptor() {
		def data = GradlePluginDescriptorUtil.pluginDescriptor(new File('/foo/'), new File('/foo/package/FooBarPlugin.class'))
		assertEquals(1, data.size())
		assertEquals('package.FooBarPlugin', data.'foo-bar')
	}

	@Test
	public void testPluginDescriptors() {
		def data = GradlePluginDescriptorUtil.pluginDescriptors(new File('/foo/'), [new File('/foo/package/FooBarPlugin.class'), new File('/foo/package/FooBarBazPlugin.class')])
		assertEquals(2, data.size())
		assertEquals('package.FooBarPlugin', data.'foo-bar')
		assertEquals('package.FooBarBazPlugin', data.'foo-bar-baz')
	}
}

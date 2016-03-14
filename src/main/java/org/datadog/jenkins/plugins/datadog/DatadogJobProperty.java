package org.datadog.jenkins.plugins.datadog;

import hudson.Extension;
import hudson.model.Job;
import hudson.model.JobProperty;
import jenkins.model.OptionalJobProperty;

import org.kohsuke.stapler.DataBoundConstructor;

public class DatadogJobProperty extends OptionalJobProperty<Job<?,?>> {

  private String tags = null;

  @DataBoundConstructor
  public DatadogJobProperty(final String tags) {
    super();
    this.tags = tags;
  }

  public String getTags() {
    return this.tags;
  }

  // Overridden for better type safety.
  // If your plugin doesn't really define any property on Descriptor,
  // you don't have to do this.
  @Override
  public DescriptorImpl getDescriptor() {
    return (DescriptorImpl)super.getDescriptor();
  }

  @Extension
  public static class DescriptorImpl extends OptionalJobPropertyDescriptor {

    /**
     * Runs when the {@link DescriptorImpl} class is created.
     */
    public DescriptorImpl() {
      load(); // load the persisted global configuration
    }

    @Override
    public boolean isApplicable(Class<? extends Job> jobType) {
      // Indicates that this builder can be used with all kinds of project types 
      return true;
    }

    @Override
    public String getDisplayName() {
      return DatadogBuildListener.DISPLAY_NAME;
    }

  }

}


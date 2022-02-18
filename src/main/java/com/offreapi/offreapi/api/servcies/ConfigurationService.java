package com.offreapi.offreapi.api.servcies;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.offreapi.offreapi.api.models.Configuration;

public interface ConfigurationService {
	public void createConfiguration(List<Configuration> configuration);


    public Collection<Configuration> getAllConfigurations();


    public Optional<Configuration> findConfigurationById(int id);


    public void deleteConfigurationById(int id);


    public void updateConfiguration(Configuration configuration);


    public void deleteAllConfigurations();

}

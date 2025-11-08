package com.levinzonr.template.android.features.resources.data.persistence

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.levinzonr.template.android.core.persistence.SharedPreferenceDataStore
import com.levinzonr.template.android.features.resources.domain.model.Resource
import javax.inject.Inject

class ResourcePreferenceStore @Inject constructor(
    dataStore: DataStore<Preferences>,
) : SharedPreferenceDataStore<Resource>(dataStore, Resource.serializer())

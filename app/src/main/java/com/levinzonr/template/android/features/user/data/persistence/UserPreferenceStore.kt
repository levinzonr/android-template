package com.levinzonr.template.android.features.user.data.persistence

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.levinzonr.template.android.core.persistence.SingleSharedPreferenceDataStore
import com.levinzonr.template.android.features.user.domain.model.User
import javax.inject.Inject

class UserPreferenceStore @Inject constructor(
    dataStore: DataStore<Preferences>,
) : SingleSharedPreferenceDataStore<User>(dataStore, User.serializer())

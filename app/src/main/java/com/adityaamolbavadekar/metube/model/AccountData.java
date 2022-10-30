package com.adityaamolbavadekar.metube.model;

import com.adityaamolbavadekar.metube.utils.ThrowIfNull;

public class AccountData {

    private Profile profile = null;

    private MessagingToken messagingToken = null;
    private long dateOfBirth = 0;
    private GenderType genderType = GenderType.NOT_DISCLOSED;
    private String genderCustom = null;

    public Boolean getIsMe() {
        return true;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public MessagingToken getMessagingToken() {
        return messagingToken;
    }

    public void setMessagingToken(MessagingToken messagingToken) {
        this.messagingToken = messagingToken;
    }

    public long getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public GenderType getGenderType() {
        return genderType;
    }

    public void setGenderType(GenderType genderType) {
        this.genderType = genderType;
    }

    public String getGenderCustom() {
        return genderCustom;
    }

    public void setGenderCustom(String genderCustom) {
        this.genderCustom = genderCustom;
    }

    public AccountData(Profile profile, MessagingToken messagingToken, long dateOfBirth, GenderType genderType, String genderCustom) {
        this.profile = profile;
        this.messagingToken = messagingToken;
        this.dateOfBirth = dateOfBirth;
        this.genderType = genderType;
        this.genderCustom = genderCustom;
        ThrowIfNull.check(profile, messagingToken, dateOfBirth, genderType, genderCustom);
    }

}

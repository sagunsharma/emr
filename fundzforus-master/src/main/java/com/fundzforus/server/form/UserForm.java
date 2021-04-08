package com.fundzforus.server.form;

import com.fundzforus.server.domain.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@Data
public class UserForm {
    private int userId;
    public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public MultipartFile getMultiPartImage() {
		return multiPartImage;
	}

	public void setMultiPartImage(MultipartFile multiPartImage) {
		this.multiPartImage = multiPartImage;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getUserTenantId() {
		return userTenantId;
	}

	public void setUserTenantId(String userTenantId) {
		this.userTenantId = userTenantId;
	}

	public boolean isReceiveNotification() {
		return receiveNotification;
	}

	public void setReceiveNotification(boolean receiveNotification) {
		this.receiveNotification = receiveNotification;
	}

	public List<Partner> getPartners() {
		return partners;
	}

	public void setPartners(List<Partner> partners) {
		this.partners = partners;
	}

	public List<List<Partner>> getPartnersList() {
		return partnersList;
	}

	public void setPartnersList(List<List<Partner>> partnersList) {
		this.partnersList = partnersList;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public PartnerImage getNewPartnerImage() {
		return newPartnerImage;
	}

	public void setNewPartnerImage(PartnerImage newPartnerImage) {
		this.newPartnerImage = newPartnerImage;
	}

	public List<PartnerImage> getPartnerImages() {
		return partnerImages;
	}

	public void setPartnerImages(List<PartnerImage> partnerImages) {
		this.partnerImages = partnerImages;
	}

	public List<List<PartnerImage>> getPartnerImagesList() {
		return partnerImagesList;
	}

	public void setPartnerImagesList(List<List<PartnerImage>> partnerImagesList) {
		this.partnerImagesList = partnerImagesList;
	}

	public List<PartnerVideo> getPartnerVideos() {
		return partnerVideos;
	}

	public void setPartnerVideos(List<PartnerVideo> partnerVideos) {
		this.partnerVideos = partnerVideos;
	}

	public Partner getNewPartner() {
		return newPartner;
	}

	public void setNewPartner(Partner newPartner) {
		this.newPartner = newPartner;
	}

	public PartnerVideo getNewPartnerVideo() {
		return newPartnerVideo;
	}

	public void setNewPartnerVideo(PartnerVideo newPartnerVideo) {
		this.newPartnerVideo = newPartnerVideo;
	}

	public List<Program> getPrograms() {
		return programs;
	}

	public void setPrograms(List<Program> programs) {
		this.programs = programs;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public Program getNewProgram() {
		return newProgram;
	}

	public void setNewProgram(Program newProgram) {
		this.newProgram = newProgram;
	}

	public ProgramBooking getProgramBooking() {
		return programBooking;
	}

	public void setProgramBooking(ProgramBooking programBooking) {
		this.programBooking = programBooking;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Message getNewMessage() {
		return newMessage;
	}

	public void setNewMessage(Message newMessage) {
		this.newMessage = newMessage;
	}

	public List<UserVideo> getUserVideos() {
		return userVideos;
	}

	public void setUserVideos(List<UserVideo> userVideos) {
		this.userVideos = userVideos;
	}

	public UserVideo getNewVideo() {
		return newVideo;
	}

	public void setNewVideo(UserVideo newVideo) {
		this.newVideo = newVideo;
	}

	public List<NewsReader> getNewsReaderList() {
		return newsReaderList;
	}

	public void setNewsReaderList(List<NewsReader> newsReaderList) {
		this.newsReaderList = newsReaderList;
	}

	public List<List<NewsReader>> getNewsReaderSubList() {
		return newsReaderSubList;
	}

	public void setNewsReaderSubList(List<List<NewsReader>> newsReaderSubList) {
		this.newsReaderSubList = newsReaderSubList;
	}

	public NewsReader getNewsReaderNew() {
		return newsReaderNew;
	}

	public void setNewsReaderNew(NewsReader newsReaderNew) {
		this.newsReaderNew = newsReaderNew;
	}

	public NewsReader getNewsReader() {
		return newsReader;
	}

	public void setNewsReader(NewsReader newsReader) {
		this.newsReader = newsReader;
	}

	public List<Tenant> getTenants() {
		return tenants;
	}

	public void setTenants(List<Tenant> tenants) {
		this.tenants = tenants;
	}

	public boolean isFirstVideoExist() {
		return firstVideoExist;
	}

	public void setFirstVideoExist(boolean firstVideoExist) {
		this.firstVideoExist = firstVideoExist;
	}

	public boolean isSecondVideoExist() {
		return secondVideoExist;
	}

	public void setSecondVideoExist(boolean secondVideoExist) {
		this.secondVideoExist = secondVideoExist;
	}

	public boolean isThirdVideoExist() {
		return thirdVideoExist;
	}

	public void setThirdVideoExist(boolean thirdVideoExist) {
		this.thirdVideoExist = thirdVideoExist;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	private boolean loggedIn;
    private String message;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String location;
    private MultipartFile multiPartImage;
    private String imageUrl;
    private String userTenantId;
    private boolean receiveNotification;
    private List<Partner> partners;
    private List<List<Partner>> partnersList;
    private Partner partner;
    private PartnerImage newPartnerImage;
    private List<PartnerImage> partnerImages;
    private List<List<PartnerImage>> partnerImagesList;
    private List<PartnerVideo> partnerVideos;
    private Partner newPartner;
    private PartnerVideo newPartnerVideo;

    private List<Program> programs;
    private Program program;
    private Program newProgram;
    private ProgramBooking programBooking;

    private List<Message> messages;
    private Message newMessage;

    private List<UserVideo> userVideos;
    private UserVideo newVideo;
    
    private List<NewsReader> newsReaderList;
    private List<List<NewsReader>> newsReaderSubList;
    private NewsReader newsReaderNew;
    private NewsReader newsReader;

    private List<Tenant> tenants;

    private boolean firstVideoExist;
    private boolean secondVideoExist;
    private boolean thirdVideoExist;

    private boolean isAdmin;
}

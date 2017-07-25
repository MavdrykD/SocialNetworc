package com.social_network.entity;

import com.social_network.utility.Gender;
import com.social_network.utility.Role;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;


@Entity
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private String email;
	private LocalDate birthday;

	private boolean enable;
	private String uuid;

	@Enumerated(EnumType.STRING)
	private Gender Gender;

	@Enumerated
	@LazyCollection(LazyCollectionOption.FALSE)
	private Role role;

	@OneToMany(mappedBy = "user")
	private List<FriendshipOffer> friendshipOffers = new ArrayList<FriendshipOffer>();

	@OneToMany(mappedBy = "friend")
	private List<FriendshipOffer> receivedOffers = new ArrayList<FriendshipOffer>();

	@ManyToMany
	@JoinTable(name = "friends", joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "friend_id"))
	private List<User> friends = new ArrayList<User>();

	@OneToMany(mappedBy = "userSender")
	private List<Message>sendingAMessage = new ArrayList<Message>();

	@OneToMany(mappedBy = "userReceiver")
	private List<Message>receivedMessages = new ArrayList<Message>();

	@ManyToOne
	private MaritalStatus maritalStatus;

	@OneToMany(mappedBy = "user")
	private List<WallPosts> WallPosts = new ArrayList<WallPosts>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<UserPhotos> Images = new ArrayList<>();


	public User() {
	}

	public User(String firstName, String lastName, String login, String password, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.email = email;
	}

	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getUser_id() {
		return id;
	}

	public void setUser_id(int user_id) {
		this.id = user_id;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public List<Message> getSendingAMessage() {
		return sendingAMessage;
	}

	public void setSendingAMessage(List<Message> sendingAMessage) {
		this.sendingAMessage = sendingAMessage;
	}

	public List<Message> getReceivedMessages() {
		return receivedMessages;
	}

	public void setReceivedMessages(List<Message> receivedMessages) {
		this.receivedMessages = receivedMessages;
	}

	public Gender getGender() {
		return Gender;
	}

	public void setGender(Gender gender) {
		Gender = gender;
	}

	public List<FriendshipOffer> getFriendshipOffers() {
		return friendshipOffers;
	}

	public void setFriendshipOffers(List<FriendshipOffer> friendshipOffers) {
		this.friendshipOffers = friendshipOffers;
	}

	public List<com.social_network.entity.WallPosts> getWallPosts() {
		return WallPosts;
	}

	public void setWallPosts(List<com.social_network.entity.WallPosts> wallPosts) {
		WallPosts = wallPosts;
	}

	public List<UserPhotos> getImages() {
		return Images;
	}

	public void setImages(List<UserPhotos> images) {
		Images = images;
	}

	public List<FriendshipOffer> getReceivedOffers() {
		return receivedOffers;
	}

	public void setReceivedOffers(List<FriendshipOffer> receivedOffers) {
		this.receivedOffers = receivedOffers;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role.name()));
		return authorities;
	}

	@Override
	public String getUsername() {
		return String.valueOf(id);
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enable;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	@Override
	public String toString() {
		return "User{" +
				"user_id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", login='" + login + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return id == user.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
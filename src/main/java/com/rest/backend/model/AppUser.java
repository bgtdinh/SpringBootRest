package com.rest.backend.model;

import java.util.ArrayList;
import java.util.Collection;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// @Entity
// @Table(name= "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
// public class User {




//   public long getId() {
//     return id;
//   }


//   public void setId(long id) {
//     this.id = id;
//   }


//   public String getFirstName() {
//     return firstName;
//   }


//   public void setFirstName(String firstName) {
//     this.firstName = firstName;
//   }


//   public String getLastName() {
//     return lastName;
//   }


//   public void setLastName(String lastName) {
//     this.lastName = lastName;
//   }


//   public String getEmail() {
//     return email;
//   }


//   public void setEmail(String email) {
//     this.email = email;
//   }


//   public String getPassword() {
//     return password;
//   }


//   public void setPassword(String password) {
//     this.password = password;
//   }

//   @Id
//   @GeneratedValue(strategy = GenerationType.IDENTITY)
//   private long id;



//   @Column(name = "first_name")
//   private String firstName;
//   @Column(name = "last_name")
//   private String lastName;
//   @Column(name = "email")
//   private String email;
//   @Column(name = "password")
//   private String password;


//   @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//   @JoinTable(
//       name = "user_roles",
//       joinColumns = @JoinColumn(
//           name = "user_id", referencedColumnName = "id"
//         ),
//         inverseJoinColumns = @JoinColumn(
//       name = "role_id", referencedColumnName = "id"
//     )
//   )
//   @Column(name = "roles")
//   private Collection<Role> roles;


//   public User(String firstName, String lastName, String email, String password, Collection<Role> roles) {
//     this.firstName = firstName;
//     this.lastName = lastName;
//     this.email = email;
//     this.password = password;
//     this.roles = roles;
//   }



// }
@Entity
@Data
@NoArgsConstructor
public class AppUser {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;
  private String username;
  private String password;
  @ManyToMany(fetch = FetchType.EAGER)
  private Collection<Role> roles = new ArrayList<>();


  public AppUser(String name, String username, String password, Collection<Role> roles) {
    this.name = name;
    this.username = username;
    this.password = password;
    this.roles = roles;
  }


}
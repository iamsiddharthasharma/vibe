import React from "react";
import styles from './SignUp.css';
export default function SignUp() {
  return (
    <div className="signup">
      {/* Created By CodingLab - www.codinglabweb.com */}
      <meta charSet="UTF-8" />
      {/*-<title> Responsive Registration Form | CodingLab </title>-*/}

      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <div className="container">
        <div className="title">Registration</div>
        <div className="content">
          <form action="#">
            <div className="user-details">
              <div className="input-box">
                <span className="details">Full Name</span>
                <input type="text" placeholder="Enter your name" name="fullName" required="" />
              </div>
              <div className="input-box">
                <span className="details">Username</span>
                <input
                  type="text"
                  name="userName"
                  placeholder="Enter your username"
                  required=""
                />
              </div>
              <div className="input-box">
                <span className="details">Email</span>
                <input type="email" placeholder="Enter your email" name="email" required="" />
              </div>
              <div className="input-box">
                <span className="details">Phone Number</span>
                <input
                  type="text"
                  placeholder="Enter your number"
                  
                  name="phone"
                  required=""
                />
              </div>
              <div className="input-box">
                <span className="details">Password</span>
                <input
                  type="password"
                  name="pass"
                  placeholder="Enter your password"
                  required=""
                />
              </div>
              <div className="input-box">
                <span className="details">Confirm Password</span>
                <input
                  type="password"
                  name="pass2"
                  placeholder="Confirm your password"
                  required=""
                />
              </div>
            </div>
            <div className="gender-details">
              <input type="radio" name="gender" id="dot-1" />
              <input type="radio" name="gender" id="dot-2" />
              <input type="radio" name="gender" id="dot-3" />
              <span className="gender-title">Gender</span>
              <div className="category">
                <label htmlFor="dot-1">
                  <span className="dot one" />
                  <span className="gender">Male</span>
                </label>
                <label htmlFor="dot-2">
                  <span className="dot two" />
                  <span className="gender">Female</span>
                </label>
              </div>
            </div>
            <div className="button">
              <input type="submit" defaultValue="Register" />
            </div>
          </form>
        </div>
      </div>
      </div>
  );
}

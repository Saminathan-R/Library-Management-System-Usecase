import React from "react";
import { Link } from "react-router-dom";
import "./signup.css";

const Signup =()=> {
    return(
        <div className="title">
        <h1>Register for New User </h1>
        <form className="form">
       <div className="form-group mb-2">
            {/* <label className="form-label">name</label> <br/>
            <input type="text" placeholder="Enter your name" name="name"></input> <br/> */}
            <label className="form-label">Usermail </label> <br/>
            <input type="email" placeholder="Enter your email" name="email "></input> <br/>
            <label className="form-label">Password </label> <br/>
            <input type="text" placeholder="Enter a password" name="password "></input> <br/> <br/>
            <label className="form-label">Role </label> <br/>
            <input type="text" placeholder="member/staff" name="role"></input> <br/>
            <Link to="loginpage" className="btn btn-primary">Submit </Link>
            </div>
</form>
   </div>
    )
}

export default Signup;
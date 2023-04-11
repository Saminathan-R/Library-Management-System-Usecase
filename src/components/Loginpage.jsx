import { Button } from "bootstrap";
import  React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const Loginpage =()=> { 
    const navigate = useNavigate();
    const [user,setuser]=useState({
        usermail:"",
        password:"",
        role:""
    })
    const {usermail,password,role}=user;
    const onInputChange =(e) => {
        setuser({...user, [e.target.name]:e.target.value });
        };      
        const onSubmit =async(e) => {
            e.preventDefault();
            await axios.post("http://localhost:8081/login/add",user);
            navigate('/signup')
            // if(role=="member"){
            // navigate('/memberHomePage');
            // }
            // else if(role == "staff"){
            //     navigate('/staffHomePage');
            // }
            // else{
            //     navigate('/login');
            // }
        };
    return(
        <div className="title">
        <h1 >Login </h1>
        <form className="form">
        <div className="form-group mb-2">
            <label className="form-label">Usermail</label> <br/>
            <input type="text" placeholder="Enter your E-mail" name="usermail" value={usermail} onChange={(e) => onInputChange(e)}></input> <br/> <br/>
            <label className="form-label">Password </label> <br/> 
            <input type="password" placeholder="Enter your password" name="password" value = {password} onChange={(e) => onInputChange(e)}></input> <br/> <br/>
            <label className="form-label">Role </label> <br/>
            <input type="text" placeholder="member/staff" name="role" value={role} onChange={(e) => onInputChange(e)}></input> <br/>
            <button className="btn btn-primary" onClick={(e)=>onSubmit(e)}>Submit </button>
            </div>
        </form>
               
        </div>
    )
}

export default Loginpage;
import React from "react";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Routes , Route } from "react-router-dom";
import NavigationBar from "./components/NavigationBar";
import Welcome from "./components/Welcome";
import { Container, Row, Jumbotron, Col } from "react-bootstrap";
import Book from "./components/Book";
import BookList from "./components/BookList";
import Signup from "./components/Signup"
import Loginpage from "./components/Loginpage"
import axios from "axios";

function App() {
  const marginTop = { marginTop: "20px" };
  return (
    <Router>
      <NavigationBar />
      <Container>
        <Row>
          <Col lg={12} style={marginTop}>
            <Routes>
              <Route path='/' element={<Welcome/>} />
              <Route path='/add' element={<Book/>} />
              <Route path='/edit/:id' element={<Book/>} />
              <Route path='/list' element={<BookList/>} />
              <Route path='/loginpage' element={<Loginpage/>} />
              <Route path='/signup' element={<Signup/>} />
            </Routes>
          </Col>
        </Row>
      </Container>
      <p>Library Management System</p>

    </Router>
  );
}

export default App;
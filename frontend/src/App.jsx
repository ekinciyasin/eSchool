import React, { useState } from "react";
import Header from "./components/Header";
import Features from "./components/Features";
import Courses from "./components/Courses";
import Testimonials from "./components/Testimonials";
import Footer from "./components/Footer";
import "./App.css";
import HeaderMenu from "./components/HeaderMenu";
import EventList from "./components/EventList";
import AuthContent from "./context/AuthContent";
import { CardGroup } from "react-bootstrap";
import ClickableCard from "./components/ClickableCard";
import { useUser } from "./context/UserContext";

function App() {
  const { user, isLoggedIn, logoutUser } = useUser();

  let studentTools = (
    <CardGroup>
      <ClickableCard
        title={"My Grades"}
        description={
          "The 'My Grade' section offers students a quick summary of their academic performance, including grades and assessments in various courses."
        }
      />
      <ClickableCard
        title={"Attendance Status"}
        description={
          "Track your attendance effortlessly with the Attendance Status feature. Monitor your class presence and stay informed about your academic engagement."
        }
      />
      <ClickableCard
        title={"Lesson Program"}
        description={
          "Displays daily/weekly classes, subjects, and timings. Helps students stay organized."
        }
      />
    </CardGroup>
  );

  return (
    <div className="app">
      <HeaderMenu />
      {isLoggedIn ? studentTools : <Header />}
      <EventList />
      <Features />
      <Courses />
      <Testimonials />
      <AuthContent />
      <Footer />
    </div>
  );
}

export default App;

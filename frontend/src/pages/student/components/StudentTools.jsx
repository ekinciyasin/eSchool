import React from "react";
import { CardGroup, Row } from "react-bootstrap";
import ClickableCard from "../../../components/ClickableCard";
import { request, setAuthHeader } from "../../../services/axios_helper";
import { Link } from "react-router-dom";

function StudentTools() {
  const handleMyGradesClick = async () => {
    try {
      const response = await request("GET", "/api/1.0/grades/projection/1");
      console.log(response);
    } catch (error) {
      console.error("handleCardClick Error:", error);
    }
  };
  const clikableCardContainerStyle = {
    display: "flex",
    flexDirection: "row",
    justifyContent: "space-between", // Distribute space between items
  };
  return (
    <div style={clikableCardContainerStyle}>
      <Row>
        <ClickableCard
          title={"My Grades"}
          description={
            "The 'My Grade' section offers students a quick summary of their academic performance, including grades and assessments in various courses."
          }
          // onClick={handleMyGradesClick}
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
      </Row>
    </div>
  );
}

export default StudentTools;

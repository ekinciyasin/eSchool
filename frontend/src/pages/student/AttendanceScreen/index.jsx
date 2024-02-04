import React, { useEffect, useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { Container, Row, Col, Table } from "react-bootstrap";
import { getStudentAttendance } from "../../../services/axios_helper";
import { useUser } from "../../../context/UserContext";

const AttendanceScreen = () => {
  const [attendances, setAttendances] = useState([]);
  const { user } = useUser();
  useEffect(() => {
    // Axios ile backend'e istek gönderme
    getStudentAttendance() // BACKEND_API_URL'i kendi backend URL'inizle değiştirin
      .then((response) => {
        setAttendances(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.error("Error fetching student grades:", error);
      });
  }, []);

  return (
    <Container className="mt-5">
      <Row>
        <Col>
          <h2>Attendance Information</h2>
          <h5 className="mt-4">
            {user.firstName} {user.lastName}
          </h5>
        </Col>
      </Row>
      <Row className="mt-2">
        <Col>
          <Table striped bordered hover variant="secondary">
            <thead>
              <tr>
                <th>Lesson Name</th>
                <th>Date of Absence</th>
                <th>Absence Status</th>
                <th>Excuse</th>
              </tr>
            </thead>
            <tbody>
              {attendances.map((attendance, index) => (
                <tr key={index}>
                  <td>{attendance.lessonName}</td>
                  <td>{attendance.attendanceDate}</td>
                  <td>{!attendance.present && "Not Present"}</td>
                  <td>{attendance.excused ? "Excused" : "Unexcused"}</td>
                </tr>
              ))}
            </tbody>
          </Table>
        </Col>
      </Row>
    </Container>
  );
};

export default AttendanceScreen;

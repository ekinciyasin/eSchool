import { createBrowserRouter } from "react-router-dom";
import HomePage from "../pages/HomePage";
import App from "../App";
import GradeTableForStudent from "../pages/student/GradeTableForStudent";
import PrivateRoute from "./PrivateRouter";

export default createBrowserRouter([
  {
    path: "/",
    Component: App,
    children: [
      {
        path: "/",
        index: true,
        Component: HomePage,
      },
      {
        path: "/grades",
        Component: GradeTableForStudent,
        render: () => (
          <PrivateRoute
            component={GradeTableForStudent}
            allowedRoles={["ROLE_STUDENT"]}
            path="/grades"
          />
        ),
      },
    ],
  },
]);

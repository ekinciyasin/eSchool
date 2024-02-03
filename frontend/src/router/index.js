import { createBrowserRouter } from "react-router-dom";
import HomePage from "../pages/HomePage";
import App from "../App";
import GradeTableForStudent from "../pages/student/GradeTableForStudent";
import PrivateRoute from "./PrivateRoute";

export default createBrowserRouter([
  {
    path: "/",
    element: <App />,
    children: [
      {
        path: "/",
        index: true,
        element: <HomePage />,
      },
      {
        path: "/grades",
        element: (
          <PrivateRoute allowedRoles={["ROLE_STUDENT"]}>
            <GradeTableForStudent />
          </PrivateRoute>
        ),
      },
    ],
  },
]);

// function requireRole(allowedRoles) {
//   return (Component) => {
//     return withAuth((props) => {
//       const isAuthenticated = // Kimlik doğrulama durumunu kontrol edin
//       const hasRole = allowedRoles.includes(props.user.role);

//       if (isAuthenticated && hasRole) {
//         return <Component {...props} />; // Yetkili ise asıl bileşeni göster
//       } else {
//         return <Navigate to="/login" />; // Yetkisiz ise yönlendir
//       }
//     });
//   };
// }

// const AuthenticatedGradeTable = requireRole(["ROLE_STUDENT"])(GradeTableForStudent);

// export default createBrowserRouter([
//   {
//     path: "/",
//     element: <App />,
//     children: [
//       {
//         path: "/",
//         index: true,
//         element: <HomePage />,
//       },
//       {
//         path: "/grades",
//         element: <AuthenticatedGradeTable />, // Yetkili bileşen direkt olarak kullanılır
//       },
//     ],
//   },
// ]);

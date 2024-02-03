import { Navigate, useLocation } from "react-router-dom";
import { useUser } from "../context/UserContext";

const PrivateRoute = ({ children, allowedRoles }) => {
  const { isLoggedIn, user } = useUser();
  const location = useLocation();

  const hasAllowedRole = user?.roles.some((role) =>
    allowedRoles.includes(role)
  );
  if (!isLoggedIn) {
    return <Navigate to="/" state={{ from: location.pathname }} />;
  } else if (!hasAllowedRole) {
    return <Navigate to="/unauthorized" />;
  }

  return children;
};

export default PrivateRoute;

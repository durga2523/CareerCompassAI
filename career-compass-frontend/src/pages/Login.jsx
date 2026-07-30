import { useState} from "react";
import { loginUser } from "../services/authService";
import { useNavigate } from "react-router-dom";
function Login(){

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    const handleLogin = async () => {

        if(!email || !password){
            alert("Please enter both email and password!");
            return
        }
        const loginData = {
            email,
            password
        };

        try {
            const response = await loginUser(loginData);

            console.log("Response:", response);
            console.log("Token:", response.token);

            localStorage.setItem("token", response.token);

            navigate("/dashboard");

            console.log("Token Saved Successfully!");

        } catch (error) {
            console.error("Error Object:", error);

            if (error.response) {
                console.log("Status:", error.response.status);
                console.log("Data:", error.response.data);
            } else {
                console.log("Message:", error.message);
            }
        }
    };

    return (
        <div className="container mt-5">
            <div className="row justify-content-center">
                <div className="col-md-5">
                    <div className="card shadow p-4">
                        <h2 className="text-center mb-4">
                            Career Compass AI
                        </h2>
                        <div className="mb-3">
                            <label className="form-label">
                                Email
                            </label>

                            <input
                                type="email"
                                className="form-control"
                                placeholder="Enter your email"
                                value={email}
                                onChange={(e) => setEmail(e.target.value)}
                                />
                        </div>

                        <div className="mb-3">
                            <label className="form-label">
                                Password
                            </label>
                        <input
                            type="password"
                            className="form-control"
                            placeholder="Enter your password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                        />
                        </div>


                        <button
                            className="btn btn-primary w-100"
                          onClick={handleLogin}>
                            Login
                        </button>

                        <p className="text-center mt-3">
                            Don't have an account? Register
                        </p>
                    </div>
                </div>
            </div>

        </div>
    )
}
export default Login;
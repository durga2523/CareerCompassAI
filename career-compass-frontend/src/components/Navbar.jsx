import "../styles/navbar.css";

function Navbar({
                    showSidebar,
                    setShowSidebar,
                    onLogout,
                    appName,
                    logout
}) {
    return (
        <div className="navbar-custom">

            <div className="navbar-left">

                <button
                    className="menu-button"
                    onClick={() => setShowSidebar(!showSidebar)}
                >
                    ☰
                </button>

                <h4 className="app-title">
                    {appName}
                </h4>

            </div>

            <button
                className="logout-button"
                onClick={onLogout}
            >
                {logout}
            </button>

        </div>
    );
}

export default Navbar;
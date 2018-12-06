import React from "react";
import "./Header.css";
import { NavLink } from "react-router-dom";

//TODO - Remove helper links

function Header(props) {
	return (
		<div className="header">
			<h1>
				<NavLink
					to="/"
					style={{ textDecoration: "none", color: "#e1e1e1" }}
				>
					{props.title}
				</NavLink>
			</h1>
			<NavLink
				style={{ color: "#e1e1e1", textDecoration: "none" }}
				to="/client-data"
			>
				/client-data >>
			</NavLink>
			<NavLink
				style={{ color: "#e1e1e1", textDecoration: "none" }}
				to="/result"
			>
				/result
			</NavLink>
		</div>
	);
}

export default Header;

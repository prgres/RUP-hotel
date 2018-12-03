import React from "react";
//TODO - error page here

function backToTheHomepage() {
	window.location.replace("/");
}

function Result(props) {
	return (
		<div
			style={{
				width: "60vw",
				height: "40vh",
				backgroundColor: "rgba(0,0,0,0.3)",
				margin: "auto",
				display: "flex",
				justifyContent: "center",
				alignContent: "center",
				flexFlow: "column",
				textAlign: "center",
				padding: "4rem",
				marginTop: "2rem",
			}}
		>
			<h2>Dziękujemy za dokonanie zakupu</h2>
			<h3>Twój zakup został zatwierdzony</h3>
			<button onClick={backToTheHomepage}>Wróć do strony głównej</button>
		</div>
	);
}

export default Result;

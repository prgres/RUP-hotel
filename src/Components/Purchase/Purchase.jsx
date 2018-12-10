import React from "react";

function Purchase(props) {
	return (
		<div
			style={{
				textAlign: "center",
				margin: "2rem auto",
				width: "90vw",
				height: "40vh",
				backgroundColor: "rgba(0,0,0,.3)",
				padding: "1rem",
			}}
		>
			<h2>TWOJE DANE ZOSTAŁY ZAAKCEPTOWANE</h2>
			<h3>Twój kod płatności to: </h3>
			<div
				style={{
					width: "80vw",
					height: "10vh",
					backgroundColor: "#e1e1e1",
					margin: "auto",
					marginTop: "2rem",
				}}
			/>
			<button>Przejdź do płatności</button>
		</div>
	);
}

export default Purchase;

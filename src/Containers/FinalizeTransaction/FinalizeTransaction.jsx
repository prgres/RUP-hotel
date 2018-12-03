import React from "react";

class FinalizeTransaction extends React.Component {
	render() {
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
				<h2>CAŁKOWITA KWOTA DO ZAPŁATY</h2>
				<h3 style={{ margin: "1rem 0", fontSize: "2rem" }}>$MILION</h3>
				<form
					style={{
						display: "flex",
						justifyContent: "center",
						alignItems: "center",
						flexFlow: "column",
					}}
				>
					<label
						style={{ marginBottom: "1rem" }}
						htmlFor="purchase-code"
					>
						Podaj swój kod płatności
					</label>
					<input
						style={{
							height: "30px",
							width: "60vw",
							padding: "10px",
							fontSize: "1.5rem",
						}}
						type="text"
						placeholder="53cr37C0d3"
					/>
					<button>Zapłać</button>
				</form>
			</div>
		);
	}
}

export default FinalizeTransaction;

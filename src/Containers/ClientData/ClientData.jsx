import React from "react";
import "./ClientData.css";

class ClientData extends React.Component {
	render() {
		return (
			<form className="clientData">
				<h2 style={{ margin: "auto " }}>Dane Osobowe</h2>
				<label htmlFor="name">Imię</label>
				<input
					className="clientData-input"
					id="name"
					type="text"
					placeholder="Jan"
				/>
				<label htmlFor="surname">Nazwisko</label>
				<input
					className="clientData-input"
					id="surname"
					type="text"
					placeholder="Kowalski"
				/>
				<label htmlFor="id-number">Numer dowodu osobistego</label>
				<input
					className="clientData-input"
					id="id-number"
					type="text"
					placeholder="ABC 2345"
				/>
				<button>Przejdź dalej</button>
			</form>
		);
	}
}

export default ClientData;

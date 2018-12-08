import React from "react";
import "./ClientData.css";
import PurchaseCode from "../../Components/Purchase/Purchase";

class ClientData extends React.Component {
	render() {
		return (
			<div>
				<form className="clientData">
					<h2 style={{ margin: "auto", textAlign: "center" }}>
						Dane Osobowe
					</h2>
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
					<button>Generuj Kod Płatności</button>
				</form>
				<PurchaseCode />
			</div>
		);
	}
}

export default ClientData;

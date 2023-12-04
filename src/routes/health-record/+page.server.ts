export async function load(event) {
	const pid = event.url.searchParams.get('pid');

	let response;

	if (event.url.searchParams.get('pid') != null) {
		response = await fetch(`http://localhost:8080/patient-record?id=${pid}`, {
			method: 'GET',
			headers: {
				'Content-Type': 'application/json'
			}
		});
	}

	if (event.url.searchParams.get('pid') != null) return response.json();
}

export const actions = {
	addDepartment: async (event) => {
		const department = {
			dcode: document.getElementById('dcode')?.value,
			name: document.getElementById('dname')?.value,
			officePhone: document.getElementById('dphone')?.value,
			officeNumber: document.getElementById('dnum')?.value,
			officeHead: document.getElementById('dhead')?.value
		};

		const response = await fetch('http://localhost:8080/add-department', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(department)
		}).then(() => {
			alert('Successfully Added');
		});

		return response;
	}
};

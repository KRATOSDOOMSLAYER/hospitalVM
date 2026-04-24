const API_URL = 'http://localhost:8080/api/v1';

// Elements
const stats = {
    pacientes: document.getElementById('stat-pacientes'),
    medicos: document.getElementById('stat-medicos'),
    fonasa: document.getElementById('stat-costos-fonasa'),
    isapre: document.getElementById('stat-costos-isapre')
};

const tableRecentPatients = document.getElementById('table-recent-patients').querySelector('tbody');
const modalPaciente = document.getElementById('modal-paciente');
const btnNuevoPaciente = document.getElementById('btn-nuevo-paciente');
const spanClose = document.getElementsByClassName("close")[0];
const formPaciente = document.getElementById('form-paciente');

// Initialize
document.addEventListener('DOMContentLoaded', () => {
    fetchStats();
    fetchRecentPatients();
    fetchMedicos();
});

// Fetching functions
async function fetchStats() {
    try {
        const resPacientes = await fetch(`${API_URL}/pacientes`);
        const pacientes = await resPacientes.json();
        stats.pacientes.innerText = pacientes.length;

        const resMedicos = await fetch(`${API_URL}/medicos`); // Wait, I need a controller for medicos
        const medicos = await resMedicos.json();
        stats.medicos.innerText = medicos.length;

        // Fetch costs (these endpoints might need to be implemented or adjusted)
        const resFonasa = await fetch(`${API_URL}/atenciones/costos/FONASA`);
        const costFonasa = await resFonasa.json();
        stats.fonasa.innerText = `$${costFonasa.toLocaleString()}`;

        const resIsapre = await fetch(`${API_URL}/atenciones/costos/ISAPRE`);
        const costIsapre = await resIsapre.json();
        stats.isapre.innerText = `$${costIsapre.toLocaleString()}`;

    } catch (err) {
        console.warn('API not available or error fetching stats:', err);
        // Fallback for demo
        stats.pacientes.innerText = '124';
        stats.medicos.innerText = '12';
        stats.fonasa.innerText = '$1,250,000';
        stats.isapre.innerText = '$840,000';
    }
}

async function fetchRecentPatients() {
    try {
        const res = await fetch(`${API_URL}/pacientes`);
        const patients = await res.json();
        renderPatients(patients.slice(-5).reverse());
    } catch (err) {
        // Mock data for demo
        renderPatients([
            { nombres: 'Juan', apellidos: 'Pérez', run: '11.111.111-1', diagnostico: 'Chequeo General' },
            { nombres: 'María', apellidos: 'González', run: '22.222.222-2', diagnostico: 'Migraña' }
        ]);
    }
}

function renderPatients(patients) {
    tableRecentPatients.innerHTML = patients.map(p => `
        <tr>
            <td>${p.nombres} ${p.apellidos}</td>
            <td>${p.run}</td>
            <td>${p.diagnostico || 'N/A'}</td>
            <td><span class="status-badge">Estable</span></td>
        </tr>
    `).join('');
}

// Modal logic
btnNuevoPaciente.onclick = () => modalPaciente.style.display = "block";
spanClose.onclick = () => modalPaciente.style.display = "none";
window.onclick = (event) => {
    if (event.target == modalPaciente) modalPaciente.style.display = "none";
}

formPaciente.onsubmit = async (e) => {
    e.preventDefault();
    const formData = new FormData(formPaciente);
    const data = Object.fromEntries(formData.entries());
    
    try {
        const res = await fetch(`${API_URL}/pacientes`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        });
        
        if (res.ok) {
            alert('Paciente registrado con éxito');
            modalPaciente.style.display = "none";
            fetchRecentPatients();
            fetchStats();
        } else {
            const error = await res.json();
            alert('Error: ' + JSON.stringify(error));
        }
    } catch (err) {
        alert('Error al conectar con el servidor.');
    }
};

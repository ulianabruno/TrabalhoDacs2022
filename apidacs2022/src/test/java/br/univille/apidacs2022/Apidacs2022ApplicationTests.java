package br.univille.apidacs2022;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

// import com.fasterxml.jackson.core.JsonpCharacterEscapes;

import br.univille.apidacs2022.api.CidadeControllerAPI;
import br.univille.apidacs2022.api.MedicoControllerAPI;
import br.univille.apidacs2022.api.PacienteControllerAPI;
import br.univille.apidacs2022.api.PlanoDeSaudeControllerAPI;
import br.univille.apidacs2022.api.ProcedimentoControllerAPI;

@SpringBootTest
@AutoConfigureMockMvc
class Apidacs2022ApplicationTests {

	@Autowired
	private PacienteControllerAPI pacienteControllerAPI;
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PlanoDeSaudeControllerAPI planoDeSaudeControllerAPI;
	@Autowired
	private ProcedimentoControllerAPI procedimentoCntrollerAPI;
	@Autowired
	private MedicoControllerAPI medicoControllerAPI;
	@Autowired
	private CidadeControllerAPI cidadeControllerAPI;

	@Test
	void contextLoads() {
		assertThat(pacienteControllerAPI).isNotNull();
		assertThat(planoDeSaudeControllerAPI).isNotNull();
		assertThat(procedimentoCntrollerAPI).isNotNull();
		assertThat(medicoControllerAPI).isNotNull();
		assertThat(cidadeControllerAPI).isNotNull();
	}

	@Test
	void pacienteControllerAPIPOSTGETTest() throws Exception {
		MvcResult resultAuth = mockMvc.perform(post("/api/v1/auth/signin")
				.content("{\"usuario\":\"admin\",\"senha\":\"admin\"}")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		String jwtToken = resultAuth.getResponse().getContentAsString();

		MvcResult resultPacientes = mockMvc.perform(post("/api/v1/pacientes")
				.content("{\"nome\":\"Zezinho\",\"sexo\":\"Masculino\"}")
				.header("Authorization", "Bearer " + jwtToken)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();

		String resultPacientesStr = resultPacientes.getResponse().getContentAsString();
		JSONObject objJsonPacientes = new JSONObject(resultPacientesStr);

		mockMvc.perform(get("/api/v1/pacientes/" + objJsonPacientes.getString("id"))
				.header("Authorization", "Bearer " + jwtToken))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.nome", is("Zezinho")))
				.andExpect(jsonPath("$.sexo", is("Masculino")));

	}

	@Test
	void medicoControllerAPIPOSTGETTest() throws Exception {

		MvcResult resultAuth = mockMvc.perform(post("/api/v1/auth/signin")
				.content("{\"usuario\":\"admin\",\"senha\":\"admin\"}")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		String jwtToken = resultAuth.getResponse().getContentAsString();

		MvcResult resultMedicos = mockMvc.perform(post("/api/v1/medicos")
				.content("{\"nome\":\"Doctora\",\"crm\":\"123456\"}")
				.header("Authorization", "Bearer " + jwtToken)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();

		String resultMedicosStr = resultMedicos.getResponse().getContentAsString();
		JSONObject objJsonMedicos = new JSONObject(resultMedicosStr);

		mockMvc.perform(get("/api/v1/medicos/" + objJsonMedicos.getString("id"))
				.header("Authorization", "Bearer " + jwtToken))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.nome", is("Doctora")))
				.andExpect(jsonPath("$.crm", is("123456")));
	}

	@Test
	void cidadeControllerAPIPOSTGETTest() throws Exception {

		MvcResult resultAuth = mockMvc.perform(post("/api/v1/auth/signin")
				.content("{\"usuario\":\"admin\",\"senha\":\"admin\"}")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		String jwtToken = resultAuth.getResponse().getContentAsString();

		MvcResult resultCidades = mockMvc.perform(post("/api/v1/cidades")
				.content("{\"nome\":\"Joinville\",\"crm\":\"123456\"}")
				.header("Authorization", "Bearer " + jwtToken)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();

		String resultCidadesStr = resultCidades.getResponse().getContentAsString();
		JSONObject objJsonCidades = new JSONObject(resultCidadesStr);

		mockMvc.perform(get("/api/v1/cidades/" + objJsonCidades.getString("id"))
				.header("Authorization", "Bearer " + jwtToken))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.nome", is("Joinville")));
	}

	@Test
	void planoDeSaudeControllerAPIPOSTGETTest() throws Exception {

		MvcResult resultAuth = mockMvc.perform(post("/api/v1/auth/signin")
				.content("{\"usuario\":\"admin\",\"senha\":\"admin\"}")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		String jwtToken = resultAuth.getResponse().getContentAsString();

		MvcResult result = mockMvc.perform(post("/api/v1/planodesaude")
				.content("{\"nome\":\"UNIMED\"}")
				.header("Authorization", "Bearer " + jwtToken)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();

		String resultStr = result.getResponse().getContentAsString();
		JSONObject objJson = new JSONObject(resultStr);

		mockMvc.perform(get("/api/v1/planodesaude/" + objJson.getString("id"))
				.header("Authorization", "Bearer " + jwtToken))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.nome", is("UNIMED")));
	}

	@Test
	void procedimentoControllerAPIPOSTGETTest() throws Exception {

		MvcResult resultAuth = mockMvc.perform(post("/api/v1/auth/signin")
				.content("{\"usuario\":\"admin\",\"senha\":\"admin\"}")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		String jwtToken = resultAuth.getResponse().getContentAsString();

		MvcResult result = mockMvc.perform(post("/api/v1/procedimentos")
				.content("{\"descricao\":\"Cirurgia\"}")
				.header("Authorization", "Bearer " + jwtToken)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();

		String resultStr = result.getResponse().getContentAsString();
		JSONObject objJson = new JSONObject(resultStr);

		mockMvc.perform(get("/api/v1/procedimentos/" + objJson.getString("id"))
				.header("Authorization", "Bearer " + jwtToken))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.descricao", is("Cirurgia")));
	}

	@Test
	void consultaControllerAPIPOSTGETTest() throws Exception {

		MvcResult resultAuth = mockMvc.perform(post("/api/v1/auth/signin")
				.content("{\"usuario\":\"admin\",\"senha\":\"admin\"}")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		String jwtToken = resultAuth.getResponse().getContentAsString();

		MvcResult result = mockMvc.perform(post("/api/v1/consultas")
				.content("{\"paciente\":\"id\":\"1\"}")
				.header("Authorization", "Bearer " + jwtToken)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();

		String resultStr = result.getResponse().getContentAsString();
		JSONObject objJson = new JSONObject(resultStr);

		mockMvc.perform(get("/api/v1/consultas/" + objJson.getString("id"))
				.header("Authorization", "Bearer " + jwtToken))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.paciente.id", is("1")));
	}

}

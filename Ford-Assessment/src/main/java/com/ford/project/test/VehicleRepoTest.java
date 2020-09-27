package com.ford.project.test;

import com.ford.project.controller.VehicleController;
import com.ford.project.service.VehicleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(VehicleController.class)
public class VehicleRepoTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private VehicleController vehicleController;

    @MockBean
    private VehicleService vehicleService;

    @Test
    public void testPersistVehicle() throws Exception {
        String json = "{\n" +
                "  \"id\": 0,\n" +
                "  \"make\": \"Ford\",\n" +
                "  \"model\": \"Flex\",\n" +
                "  \"modelYear\": \"2021\",\n" +
                "  \"bodyStyle\": \"SUV\",\n" +
                "  \"engine\": \"AWD\",\n" +
                "  \"driveType\": \"AWD\",\n" +
                "  \"color\": \"red\",\n" +
                "  \"MPG\": 40,\n" +
                "  \"msrp\": 35000,\n" +
                "  \"savings\": 2000,\n" +
                "  \"finalPrice\": 33000\n" +
                "}\n";

        mvc.perform(post("/vehicleInfomation/submitVehicle").content(json)
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllVehicles() throws Exception {
        mvc.perform(get("/getVehicleInfomation"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testGetVehicleByModelName() throws Exception {
        mvc.perform(get("/getVehicleModelName/Edge"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testGetVehicleWithinPriceRange() throws Exception {
        mvc.perform(get("/getVehiclePrice/10000/20000"))
                .andExpect(status().isOk())
                .andReturn();
    }

}
package br.edu.iff.ccc.bsi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import br.edu.iff.ccc.bsi.entities.Device;
import br.edu.iff.ccc.bsi.entities.Task;
import br.edu.iff.ccc.bsi.repository.DeviceRepository;

@DataJpaTest
public class DeviceQueryTest {

    @Mock
    private DeviceRepository deviceRepository;
    
    
    @BeforeEach
	public void setup()
	{
		MockitoAnnotations.openMocks(this);
	}
    
    @Test
    public void testFindByName() {
        // cenário
        Device mockedDevice = new Device();
        mockedDevice.setName("Device1");
        mockedDevice.setAddress("19216811");
        
        
        //Deepseek mandou colocar isso
        // Configura o comportamento do mock do TaskRepository
        when(deviceRepository.findByName("Device1")).thenReturn(List.of(mockedDevice));

        // ação
        List<Device> result = deviceRepository.findByName("Device1");
        
        // verificação
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Device1", result.get(0).getName());
    }

    @Test
    public void testFindByAddress() {
        // cenário
        Device mockedDevice = new Device();
        mockedDevice.setName("Device2");
        mockedDevice.setAddress("19216812");
        
        //Deepseek mandou colocar isso
        // Configura o comportamento do mock do TaskRepository
        when(deviceRepository.findByAddress("19216812")).thenReturn(mockedDevice);
        
        // ação
        Device result = deviceRepository.findByAddress("19216812");

        // verificação
        assertNotNull(result);
        assertEquals("19216812", result.getAddress());
    }
}
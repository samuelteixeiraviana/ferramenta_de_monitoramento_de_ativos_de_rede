package br.edu.iff.ccc.bsi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
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
    
    @Mock
    private DeviceService deviceService;
    
    
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
        when(deviceRepository.findByAddress("19216812")).thenReturn(List.of(mockedDevice));
        
        // ação
        List<Device> result = deviceRepository.findByAddress("19216812");

        // verificação
        assertNotNull(result);
        assertEquals("19216812", result.get(0).getAddress());
    }
    
    @Test
    public void testInsertIntoDevice() {
    	// cenário
    	Device mockedDevice = new Device();
        mockedDevice.setName("Device3");
        mockedDevice.setAddress("19216813");
        
        //Deepseek mandou colocar isso
        // Configura o comportamento do mock do TaskRepository
        doNothing().when(deviceService).insertDevice("Device3", "19216813");
        
        // ação
        deviceService.insertDevice("Device3", "19216813");
        
        // verificação
        verify(deviceService).insertDevice("Device3", "19216813");
    }
    
    @Test
    public void testDeleteByAddress() {
    	// cenário
    	Device mockedDevice = new Device();
        mockedDevice.setName("Device4");
        mockedDevice.setAddress("19216814");
        
        //Deepseek mandou colocar isso
        // Configura o comportamento do mock do TaskRepository
        doNothing().when(deviceService).insertDevice("Device4", "19216814");
        doNothing().when(deviceRepository).deleteByAddress("19216814");
        
        // ação
        deviceService.insertDevice("Device4", "19216814");
        deviceRepository.deleteByAddress("19216814");

        // verificação
        verify(deviceRepository).deleteByAddress("19216814");
    }
}
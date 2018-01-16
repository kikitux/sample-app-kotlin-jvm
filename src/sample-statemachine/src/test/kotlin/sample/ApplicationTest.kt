package sampleTests

import sample.States
import sample.Events
import sample.SampleListener

import org.junit.Assert.*
import org.junit.Test

class ApplicationTests {

    private var Application = sample.Application()
    private var machine = Application.stateMachine()


    @Test
    @Throws(Exception::class)
    fun testInitialState() {

        assertNotSame(null, States.Active)
        assertNotSame(null, States.Idle)
        assertNotSame(States.Active, States.Idle)

        assertSame(null, machine.state)
    }

    @Test
    @Throws(Exception::class)
    fun testStartBecomesIdle() {
        machine.addStateListener(SampleListener())
        machine.start()

        assertSame(States.Idle, machine.state.id)
    }

    @Test
    @Throws(Exception::class)
    fun testEventOnChangeStateToActive() {
        machine.addStateListener(SampleListener())
        machine.start()
        machine.sendEvent(Events.On)

        assertNotSame(States.Idle, machine.state.id)
        assertSame(States.Active, machine.state.id)
    }

    @Test
    @Throws(Exception::class)
    fun testEventOffChangeStateToIdle() {
        machine.addStateListener(SampleListener())
        machine.start()
        machine.sendEvent(Events.Off)

        assertNotSame(States.Active, machine.state.id)
        assertSame(States.Idle, machine.state.id)
    }

}
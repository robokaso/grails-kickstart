package boil

import grails.plugin.spock.IntegrationSpec

import com.icegreen.greenmail.util.GreenMailUtil


class EmailIntegrationSpec extends IntegrationSpec {

	def mailService
	def greenMail

	void 'send mail'() {
		
		when:
			Map mail = [message:'hello world', from:'from@piragua.com', to:'to@piragua.com', subject:'subject']
	
			mailService.sendMail {
				to mail.to
				from mail.from
				subject mail.subject
				body mail.message
			}

		then:
			greenMail.receivedMessages.length == 1

			def message = greenMail.receivedMessages.head()

			GreenMailUtil.getBody(message) == mail.message
		    GreenMailUtil.getAddressList(message.from) == mail.from
		    message.subject == mail.subject
	}

	def cleanup() {
		greenMail.deleteAllMessages()
	}
}
